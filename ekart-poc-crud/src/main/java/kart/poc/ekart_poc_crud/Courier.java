package kart.poc.ekart_poc_crud;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
    private int parcelId;
    private String receiverName;
    private String parcelItemName;
    private String receiverAddress;
    private long receiverContact;
    private double itemPrice;
    private String itemStatus; // transit / delivered
    private String executiveName;
}

