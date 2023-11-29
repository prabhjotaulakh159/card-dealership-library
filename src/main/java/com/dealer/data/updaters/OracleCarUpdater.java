package com.dealer.data.updaters;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dealer.data.Constants;
import com.dealer.data.OracleConnector;
import com.dealer.data.exceptions.LoaderException;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.models.cars.RecreationalVehicle;

/**
 * Implements ICarUpdater to update/query cars in an oracle database
 * @author Prabhjot Aulakh, Safin Haque
 */
public class OracleCarUpdater extends OracleConnector implements ICarUpdater {
    /**
     * Creates a car in the oracle database
     * @param car Car to create/insert
     * @throws LoaderException If SQL error occurs
     */
    @Override
    public void create(Car car) throws LoaderException {
        String carSQL = "INSERT INTO car (type, model, year, color, price) VALUES (?, ?, ?, ?, ?)";
        String electricSQL = "INSERT INTO car (type, model, year, color, price, voltage, charger) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String rvSQL = "INSERT INTO car (type, model, year, color, price, max_pass, num_beds, kitchen) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
                preparedStatement.setInt(8, ((RecreationalVehicle) car).isHasKitchen() ? 1 : 0);
            }
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setInt(3, car.getYear());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setInt(5, car.getPrice());
            preparedStatement.execute();
            preparedStatement.close();
            this.getConnection().commit();
        } catch (SQLException e) {
            throw new LoaderException(e);
        }
    }

    /**
     * Updates a car in the oracle database
     * @param car New car information
     * @param index Index/row to update
     * @throws LoaderException If SQLException occurs
     */
    @Override
    public void update(Car car, int index) throws LoaderException {
        try {
            int idToUpdate = 0;
            String SQL = "SELECT * FROM car ORDER BY id ASC";
            PreparedStatement preparedStatement = this.getConnection().prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getRow() == index) {
                    idToUpdate = resultSet.getInt(1);
                }
            }
            if (idToUpdate == 0) {
                throw new IllegalArgumentException("Index not found !");
            }
            String updateSQL  =  "UPDATE car SET type=?, model=?, year=?, color=?, price=?, voltage=?, charger=?, max_pass=?, num_beds=?, kitchen=? WHERE id=?";
            PreparedStatement updateStatement = this.getConnection().prepareStatement(updateSQL);
            updateStatement.setString(2, car.getModel());
            updateStatement.setInt(3, car.getYear());
            updateStatement.setString(4, car.getColor());
            updateStatement.setInt(5, car.getPrice());
            updateStatement.setInt(11, idToUpdate);
            if (!(car instanceof ElectricCar) && (!(car instanceof RecreationalVehicle))) {
                updateStatement.setString(1, Constants.CAR_TYPE);
                updateStatement.setInt(6, 0);
                updateStatement.setString(7, null);
                updateStatement.setInt(8, 0);
                updateStatement.setInt(9, 0);
                updateStatement.setInt(10, 0);
            } else if (car instanceof ElectricCar) {
                updateStatement.setString(1, Constants.ELECTRIC_TYPE);
                updateStatement.setInt(6, ((ElectricCar) car).getVoltage());
                updateStatement.setString(7, ((ElectricCar) car).getChargerType());
                updateStatement.setInt(8, 0);
                updateStatement.setInt(9, 0);
                updateStatement.setInt(10, 0);
            } else if (car instanceof RecreationalVehicle) {
                updateStatement.setString(1, Constants.RV_TYPE);
                updateStatement.setInt(6, 0);
                updateStatement.setString(7, null);
                updateStatement.setInt(8, ((RecreationalVehicle) car).getMaxPassengers());
                updateStatement.setInt(9, ((RecreationalVehicle) car).getNumberOfBeds());
                updateStatement.setInt(10, ((RecreationalVehicle) car).isHasKitchen() ? 1 : 0);
            }
            updateStatement.execute();
            updateStatement.close();
            resultSet.close();
            this.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoaderException(e);
        }
    }

    /**
     * Deletes a car in the oracle database
     * @param index Index/row to delete
     * @throws LoaderException If SQLException occurs
     */
    @Override
    public void delete(int index) throws LoaderException {
        String SQL = "SELECT id FROM car ORDER BY id ASC";
        try {
            int idToDelete = 0;
            PreparedStatement preparedStatement = this.getConnection().prepareStatement(SQL, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getRow() == index) {
                    idToDelete = resultSet.getInt(1);
                }
            }
            SQL = "DELETE FROM car WHERE id = ?";
            preparedStatement = this.getConnection().prepareStatement(SQL);
            preparedStatement.setInt(1, idToDelete);
            preparedStatement.execute();
            preparedStatement.close();
            resultSet.close(); 
            this.getConnection().commit();
        } catch (SQLException e){
            throw new LoaderException(e);
        }
    }
}
