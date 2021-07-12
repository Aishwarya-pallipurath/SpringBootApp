package com.cg.ebs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Payment {
	@OneToOne
	private  Consumer consumer;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	private String paymentMode;
	private String cardNumber;
    private String cardHolderName;
	private String expiryDate;
	private int cvv;
	private int otp;
	/**
	 * return the payment id
	 * @return
	 */
	public int getId() {
		return paymentId;
	}
	/**
	 * set the payment
	 * @param paymentId
	 */
	public void setId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * get the payment mode
	 * @return
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * set the payment mode
	 * @param paymentMode
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	/**
	 * get the card number
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}
	/**
	 * set the card number
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**
	 * get the card holder name
	 * @return
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}
	/**
	 * set the card holder name
	 * @param cardHolderName
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	/**
	 * get the Expiry date
	 * @return
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * set the expiry date
	 * @param expiryDate
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	/**
	 * get the cvv number
	 * @return
	 */
	public int getCvv() {
		return cvv;
	}
	/**
	 * set the cvv number
	 * @param cvv
	 */
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	/**
	 * get the otp number
	 * @return
	 */
	public int getOtp() {
		return otp;
	}
	/**
	 * set the otp number
	 * @param otp
	 */
	public void setOtp(int otp) {
		this.otp = otp;
	}
}