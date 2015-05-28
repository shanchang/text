package model;

import java.sql.Timestamp;

/**
 * Consume entity. @author MyEclipse Persistence Tools
 */

public class Consume implements java.io.Serializable {

	// Fields

	private Timestamp consumerDate;
	private String accountId;
	private Long saveMoney;
	private Long getMoney;

	// Constructors

	/** default constructor */
	public Consume() {
	}

	/** minimal constructor */
	public Consume(Timestamp consumerDate, String accountId) {
		this.consumerDate = consumerDate;
		this.accountId = accountId;
	}

	/** full constructor */
	public Consume(Timestamp consumerDate, String accountId, Long saveMoney,
			Long getMoney) {
		this.consumerDate = consumerDate;
		this.accountId = accountId;
		this.saveMoney = saveMoney;
		this.getMoney = getMoney;
	}

	// Property accessors

	public Timestamp getConsumerDate() {
		return this.consumerDate;
	}

	public void setConsumerDate(Timestamp consumerDate) {
		this.consumerDate = consumerDate;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Long getSaveMoney() {
		return this.saveMoney;
	}

	public void setSaveMoney(Long saveMoney) {
		this.saveMoney = saveMoney;
	}

	public Long getGetMoney() {
		return this.getMoney;
	}

	public void setGetMoney(Long getMoney) {
		this.getMoney = getMoney;
	}

}