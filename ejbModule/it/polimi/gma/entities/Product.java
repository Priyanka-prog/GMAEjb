package it.polimi.gma.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name="Product", schema="gma")
@NamedQuery(name="Product.getProductResults", query="SELECT p FROM Product p WHERE p.pname= :name")
public class Product implements Serializable{
	String pfordate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;

	@Basic(fetch=FetchType.EAGER)
	@Lob
	private byte[] pimage;
	
	//private String pfordate;
 
    //private Date end;
	public Product() {}
	
	public Product(String name) {
		pname = name;
	}
	
	public Product(String name, byte[] img) {
		pname = name;
		pimage = img;
	}
	
	public int getPID() {
		return this.pid;
	}

	public void setPID(int pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return this.pname;
	}

	public void setName(String name) {
		this.pname = name;
	}

	public String getPimage() {
		return Base64.getMimeEncoder().encodeToString(pimage);
	}

	public void setPimage(byte[] image) {
		this.pimage = image;
	}
	
	/*public String getPfordate() {
		return this.pfordate;
	}

	public void setPfordate(String now) {
		this.pfordate = now;
	}*/
	public void setpfordate(String pfordate) {
	   this.pfordate = pfordate;
	}

	public String getPfordate() {
	   return this.pfordate;
	}
	 
}
