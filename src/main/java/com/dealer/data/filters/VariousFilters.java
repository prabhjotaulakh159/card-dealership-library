package com.dealer.data.filters;

import com.dealer.data.filters.ListFilter;

public class VariousFilters {
    private ListFilter filter;

    public VariousFilters(ListFilter filter){
      this.filter= filter;
    }

    public boolean equalsTo(){
      return this.filter == ListFilter.EQUALS;
    }

    public boolean greaterThan(){
      return this.filter == ListFilter.GREATERTHAN;
    }

    public boolean lessThan(){
      return this.filter == ListFilter.LESSTHAN;
    }

    public boolean greaterThanEqualsTo(){
      return this.filter == ListFilter.GREATEREQUALS;
    }

    public boolean lessThanEqualsTo(){
      return this.filter == ListFilter.LESSEQUALS;
    }
}
