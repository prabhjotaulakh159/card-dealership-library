package com.dealer.data.updaters;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dealer.data.Constants;
import com.dealer.data.OracleConnector;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.loaders.OracleLoader;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Implements ICarUpdater to update/query cars in an oracle database
 * @author Prabhjot Aulakh, Safin Haque
 */
public class OracleCarUpdater extends OracleConnector implements ICarUpdater {
    private OracleLoader oracleLoader;

    public OracleCarUpdater(OracleLoader oracleLoader) throws LoaderException {
        super();
        this.oracleLoader = oracleLoader;
    }

    /**
     * Creates a car in the oracle database
     * @param car Car to create/insert
     * @throws LoaderException If SQL error occurs
     */
    @Override
    public void create(Car car) throws LoaderException {
        String carSQL = "INSERT INTO programming_cars (type, model, year, color, price) VALUES (?, ?, ?, ?, ?)";
        String electricSQL = "INSERT INTO programming_cars (type, model, year, color, price, voltage, charger) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String rvSQL = "INSERT INTO programming_cars (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            if (!(car instanceof ElectricCar) && !(car instanceof RecreationalVehicle)) {
                preparedStatement = this.getConnection().prepareStatement(carSQL);
                preparedStatement.setString(1, Constants.CAR_TYPE);
            } else if (car instanceof ElectricCar) {
                preparedStatement = this.getConnection().prepareStatement(electricSQL);
                preparedStatement.setString(1, Constants.ELECTRIC_TYPE);
                preparedStatement.setInt(6, ((ElectricCar) car).getVoltage());
                preparedStatement.setString(7, ((ElectricCar) car).getChargerType());
            } else if (car instanceof RecreationalVehicle) {
                preparedStatement = this.getConnection().prepareStatement(rvSQL);
                preparedStatement.setString(1, Constants.RV_TYPE);
                preparedStatement.setInt(6, ((RecreationalVehicle) car).getMaxPassengers());
                preparedStatement.setInt(7, ((RecreationalVehicle) car).getNumberOfBeds());
                preparedStatement.setInt(8, ((RecreationalVehicle) car).isHasKitchen() ? 0 : 1);
            }
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setInt(5, car.getPrice());
            preparedStatement.execute();
            preparedStatement.close();
            this.getConnection().commit();
            this.getConnection().close();
        } catch (SQLException e) {
            throw new LoaderException(e);
        }
    }

    @Override
    public void update(Car car, int index) throws LoaderException {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int index) throws LoaderException {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
