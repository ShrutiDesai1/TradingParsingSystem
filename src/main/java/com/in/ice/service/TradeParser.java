package com.in.ice.service;

import java.math.BigDecimal;

import com.in.ice.bean.Trade;

public class TradeParser {

	public static Trade parse(String line) throws Exception{
		Trade trade=new Trade();
		String str[]=line.split(";");
		if(str.length<3){
			throw new Exception();
		}
		else{
			if(str.length>=3){
				for(int i=0;i<str.length;i++){
					if(str[i].startsWith("i")){
						if(trade.getIsin()==null){
							trade.setIsin(str[i].substring(1));
						}
						else{
							throw new Exception();
						}
					}
					if(str[i].startsWith("p")){
						if(trade.getPrice()==null){
							trade.setPrice(new BigDecimal(str[i].substring(1)));
						}
						else{
							throw new Exception();
						}
					}
					if(str[i].startsWith("t")){
						if(trade.getType()==null){
							trade.setType(new Integer(str[i].substring(1)));
						}
						else{
							throw new Exception();
						}
					}
				}
			}
		}
		return trade;
	}
}
