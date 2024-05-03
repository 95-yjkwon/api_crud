package com.keduit.kyj;

public class Project {

	private int ID;
	private String tourspotNm;
	private String tourspotDtlAddr;
	private String refadNo;
	private String mngTime;
	private String tourUtlzAmt;
	private String pkgFclt;
	private String cnvenFcltGuid;
	private String tourspotSumm;

	public Project() {

	}

	public Project(int ID, String tourspotNm, String tourspotDtlAddr, String refadNo, String mngTime,
			String tourUtlzAmt, String pkgFclt, String cnvenFcltGuid, String tourspotSumm) {
		this.ID = ID;
		this.tourspotNm = tourspotNm;
		this.tourspotDtlAddr = tourspotDtlAddr;
		this.refadNo = refadNo;
		this.mngTime = mngTime;
		this.tourUtlzAmt = tourUtlzAmt;
		this.pkgFclt = pkgFclt;
		this.cnvenFcltGuid = cnvenFcltGuid;
		this.tourspotSumm = tourspotSumm;
	}

	public String getTourspotNm() {
		return tourspotNm;
	}

	public void setTourspotNm(String tourspotNm) {
		this.tourspotNm = tourspotNm;
	}

	public String getTourspotDtlAddr() {
		return tourspotDtlAddr;
	}

	public void setTourspotDtlAddr(String tourspotDtlAddr) {
		this.tourspotDtlAddr = tourspotDtlAddr;
	}

	public String getRefadNo() {
		return refadNo;
	}

	public void setRefadNo(String refadNo) {
		this.refadNo = refadNo;
	}

	public String getTourUtlzAmt() {
		return tourUtlzAmt;
	}

	public void setTourUtlzAmt(String tourUtlzAmt) {
		this.tourUtlzAmt = tourUtlzAmt;
	}

	public String getMngTime() {
		return mngTime;
	}

	public void setMngTime(String mngTime) {
		this.mngTime = mngTime;
	}

	public String getPkgFclt() {
		return pkgFclt;
	}

	public void setPkgFclt(String pkgFclt) {
		this.pkgFclt = pkgFclt;
	}

	public String getCnvenFcltGuid() {
		return cnvenFcltGuid;
	}

	public void setCnvenFcltGuid(String cnvenFcltGuid) {
		this.cnvenFcltGuid = cnvenFcltGuid;
	}

	public String getTourspotSumm() {
		return tourspotSumm;
	}

	public void setTourspotSumm(String tourspotSumm) {
		this.tourspotSumm = tourspotSumm;
	}

	@Override
	public String toString() {
		return "관광지: " + tourspotNm + "주소: " + tourspotDtlAddr + "전화번호: " + refadNo + "운영시간: " + mngTime + "이용요금: "
				+ tourUtlzAmt + "주차: " + pkgFclt + "관광정보: " + cnvenFcltGuid + "테마: " + tourspotSumm;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

}
