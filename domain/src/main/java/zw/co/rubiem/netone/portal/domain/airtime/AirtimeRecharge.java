package zw.co.rubiem.netone.portal.domain.airtime;

import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
@Entity
public class AirtimeRecharge extends BaseEntity {
    @NotBlank(message = "Recipient Number cannot be empty")
    @Column(nullable = false)
    private String recipientNumber;

    @NotBlank(message = "Recharge Amount cannot be empty")
    @Column(nullable = false)
    private double rechargeAmount;

    @NotBlank(message = "Payer Number Number cannot be empty")
    @Column(nullable = false)
    private String payerNumber;

    @NotBlank(message = "Payment Method cannot be empty")
    @Column(nullable = false)
    private String paymentMethod;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRecipientNumber() {
        return recipientNumber;
    }

    public void setRecipientNumber(String recipientNumber) {
        this.recipientNumber = recipientNumber;
    }

    public double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getPayerNumber() {
        return payerNumber;
    }

    public void setPayerNumber(String payerNumber) {
        this.payerNumber = payerNumber;
    }
}
