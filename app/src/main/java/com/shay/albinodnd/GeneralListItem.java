package com.shay.albinodnd;

import java.util.ArrayList;
import java.util.HashMap;

abstract class GeneralListItem {

    abstract String getName();
    abstract String getViewName();
    abstract String getViewDescription();
    abstract String getItemType();
    abstract ArrayList<String> getValuesToEdit();
    abstract ArrayList<String> getTypesOfValuesToEdit();
    abstract HashMap<String, Object> toMap();

}
