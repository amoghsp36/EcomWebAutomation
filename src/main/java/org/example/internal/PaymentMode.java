package org.example.internal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentMode {
    private String UPIid;
    private String cardNo;
    private String cheque;

}
