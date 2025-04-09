package com.erp.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryRequest {

    private String itemName;
    private String itemQuantity;
    private String itemDescription;
    private double itemCost;

}
