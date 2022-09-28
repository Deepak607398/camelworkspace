package com.example.apachemsb.routes;

import java.math.BigDecimal;

public class FxConverter {
	private Long fx_id;
	private String from;
	private String to;
	private BigDecimal conversionRate;

	public FxConverter() {

	}

	public FxConverter(Long fx_id, String from, String to, BigDecimal conversionRate) {
		super();
		this.fx_id = fx_id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
	}

	public Long getFx_id() {
		return fx_id;
	}

	public void setFx_id(Long fx_id) {
		this.fx_id = fx_id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}

	@Override
	public String toString() {
		return "FxConverter [fx_id=" + fx_id + ", from=" + from + ", to=" + to + ", conversionRate=" + conversionRate
				+ "]";
	}

}
