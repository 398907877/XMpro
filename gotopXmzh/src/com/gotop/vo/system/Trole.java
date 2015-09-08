package com.gotop.vo.system;

/**
 * Trole generated by MyEclipse Persistence Tools
 */

public class Trole implements java.io.Serializable {

	// Fields

	private Integer rid;

	private String roleName;

	private String note;

	private Short jszt;

	private Integer yyzt;
	
	private String orgid;

	private String rolealias;
	// Constructors

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/** default constructor */
	public Trole() {
	}

	/** minimal constructor */
	public Trole(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public Trole(String roleName, String note, Short jszt, Integer yyzt) {
		this.roleName = roleName;
		this.note = note;
		this.jszt = jszt;
		this.yyzt = yyzt;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Short getJszt() {
		return this.jszt;
	}

	public void setJszt(Short jszt) {
		this.jszt = jszt;
	}

	public Integer getYyzt() {
		return this.yyzt;
	}

	public void setYyzt(Integer yyzt) {
		this.yyzt = yyzt;
	}

	public String getRolealias() {
		return rolealias;
	}

	public void setRolealias(String rolealias) {
		this.rolealias = rolealias;
	}

}