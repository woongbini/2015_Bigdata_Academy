package com.ensoa.order.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.ensoa.order.domain.Customer;
/*µµ¸ŞÀÎÅ¬·¡½º´Â ¼­ºñ½º °è¾à ¶Ç´Â dto·Î¼­ÀÇ ¿ªÇÒÀ» ÇÏ¸ç, ¿£ÅÍÆ¼ Å¬·¡½º´Â ³ªÁß¿¡ »ìÆìº¸°ÔµÉ or¸ÅÇÎ¿¡ »ç¿ëµÈ´Ù
±×¸®°í ¸ğµ¨ Å¬·¡½º´Â ºä¿¡ »ç¿ëµÉ µ¥ÀÌÅÍ¸¦ Ç¥ÇöÇÏ´Âµ¥ »ç¿ëµÈ´Ù. 
*/

public class CustomerModel {
	private long id;
	@Size(min=2, max=10, message="ÀÌ¸§Àº 2ÀÚ ÀÌ»ó 10ÀÚ±îÁö ÀÔ´Ï´Ù")
	@Pattern(regexp="^[A-Za-z0-9°¡-ÆR]+$", message="°ø¹é¹®ÀÚ ¾øÀÌ ¼ıÀÚ¿Í ¹®ÀÚ¸¸ ÀÔ·ÂÇÏ¼¼¿ä")
	private String name;
	@Size(max=60, message="ÁÖ¼Ò´Â 60ÀÚ±îÁö ÀÔ·ÂÇÒ¼öÀÖ½À´Ï´Ù")
	private String address;
	@NotBlank(message="Á¤È®ÇÑ ÀÌ¸áÁÖ¼Ò ÀÔ·Â")
	private String email;
	
	public long getId() {	return id;	}
	public void setId(long id) {	this.id = id;	}
	public String getName() {	return name;	}
	public void setName(String name) {	this.name = name;	}
	public String getAddress() {	return address;	}
	public void setAddress(String address) {	this.address = address;	}
	public String getEmail() {	return email;	}
	public void setEmail(String email) {	this.email = email;	}
	
	public String toString() {
		return "id : " + id + ", name : " + name + ", address : " + address + ", email : " + email;
		//return "name : " + name + ", address : " + address + ", email : " + email;
	}
	
	public Customer buildDomain() {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setAddress(address);
		customer.setEmail(email);
		return customer;
	}
	
	public void buildModel(Customer customer) {
		id = customer.getId();
		name = customer.getName();
		address = customer.getAddress();
		email = customer.getEmail();
	}
	
	/*CustomerModel.java¿¡¼­´Â CustomerEntity.java¿Í À¯»çÇÏ°Ô ÀÚ½ÅÀÇ ¸ğµ¨ Å¬·¡½º ÀÎ½ºÅÏ½º·ÎºÎÅÍ µµ¸ŞÀÎ Å¬·¡½ºÀÇ
	ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ´Â buildDomain()¿Í µµ¸ŞÀÎ Å¬·¡½º ÀÎ½ºÅÏ½º·ÎºÎÅÍ ÀÚ½ÅÀÇ ¸ğµ¨ Å¬·¡½º ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ´Â
	buildDomain()°¡ Æ÷ÇÔµÈ´Ù. 
	¸ğµ¨ °´Ã¼ ¶Ç´Â ÄÃ·º¼ÇÀº jsp¿¡¼­ ÄÁÆ®·Ñ·¯ÀÇ ¿äÃ» ÇÚµé·¯ ¸Ş¼­µå¿¡ ¸ğµ¨ ¾ÖÆ®¸®ºäÆ®·Î ¸Å°³ º¯¼ö¿¡ Àü´ŞµÇ¾î
	¾÷¹« ·ÎÁ÷À» Ã³¸®ÇÏ´Âµ¥ »ç¿ëµÇ¸ç, ¿äÃ» ÇÚµé·¯ ¸Ş¼­µå·ÎºÎÅÍ ¸®ÅÏµÉ¶§ ¸ğµ¨ ¾ÖÆ®¸®ºäÆ®¿¡ Æ÷ÇÔµÇ¾î jsp¿¡¼­ 
	ºä¸¦ ·£´õ¸µÇÒ¶§ »ç¿ëµÈ´Ù.
	*/
	
}
