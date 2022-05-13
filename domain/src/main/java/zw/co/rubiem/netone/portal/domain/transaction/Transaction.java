package zw.co.rubiem.netone.portal.domain.transaction;

import zw.co.rubiem.netone.portal.domain.commons.jpa.BaseEntity;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "ux_payment_number", columnNames = {"payment_number"})})
public class Transaction extends BaseEntity {

    @Column(name = "payment_number", unique = true)
    private String paymentNumber;

    private String paymentAccount;

    private double rechargeAmount;

    private String airtimeRecipientNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;

    private String paynowReference;

    private String paynowPollUrl;

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public PaymentStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public String getPaynowReference() {
        return paynowReference;
    }

    public void setPaynowReference(String paynowReference) {
        this.paynowReference = paynowReference;
    }

    public String getAirtimeRecipientNumber() {
        return airtimeRecipientNumber;
    }

    public void setAirtimeRecipientNumber(String airtimeRecipientNumber) {
        this.airtimeRecipientNumber = airtimeRecipientNumber;
    }

    public double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getPaynowPollUrl() {
        return paynowPollUrl;
    }

    public void setPaynowPollUrl(String paynowPollUrl) {
        this.paynowPollUrl = paynowPollUrl;
    }
}
