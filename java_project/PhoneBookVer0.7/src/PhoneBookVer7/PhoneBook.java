package PhoneBookVer7;

public class PhoneBook {

	int pidx;
	String pbname;
	String pbnumber;
	String pbaddr;
	String pbemail;
	String pbmajor;
	int pbyear;
	String pbcompany;
	String pbjob;
	String pbcafename;
	String pbnickname;

	public PhoneBook() {
	};

	public PhoneBook(int pidx, String pbname, String pbnumber, String pbaddr, String pbemail, String pbmajor,
			int pbyear, String pbcompany, String pbjob, String pbcafename, String pbnickname) {
		this.pidx = pidx;
		this.pbname = pbname;
		this.pbnumber = pbnumber;
		this.pbaddr = pbaddr;
		this.pbemail = pbemail;
		this.pbmajor = pbmajor;
		this.pbyear = pbyear;
		this.pbcompany = pbcompany;
		this.pbjob = pbjob;
		this.pbcafename = pbcafename;
		this.pbnickname = pbnickname;

	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	public String getPbname() {
		return pbname;
	}

	public void setPbname(String pbname) {
		this.pbname = pbname;
	}

	public String getPbnumber() {
		return pbnumber;
	}

	public void setPbnumber(String pbnumber) {
		this.pbnumber = pbnumber;
	}

	public String getPbaddr() {
		return pbaddr;
	}

	public void setPbaddr(String pbaddr) {
		this.pbaddr = pbaddr;
	}

	public String getPbemail() {
		return pbemail;
	}

	public void setPbemail(String pbemail) {
		this.pbemail = pbemail;
	}

	public String getPbmajor() {
		return pbmajor;
	}

	public void setPbmajor(String pbmajor) {
		this.pbmajor = pbmajor;
	}

	public int getPbyear() {
		return pbyear;
	}

	public void setPbyear(int pbyear) {
		this.pbyear = pbyear;
	}

	public String getPbcompany() {
		return pbcompany;
	}

	public void setPbcompany(String pbcompany) {
		this.pbcompany = pbcompany;
	}

	public String getPbjob() {
		return pbjob;
	}

	public void setPbjob(String pbjob) {
		this.pbjob = pbjob;
	}

	public String getPbcafename() {
		return pbcafename;
	}

	public void setPbcafename(String pbcafename) {
		this.pbcafename = pbcafename;
	}

	public String getPbnickname() {
		return pbnickname;
	}

	public void setPbnickname(String pbnickname) {
		this.pbnickname = pbnickname;
	}

	@Override
	public String toString() {
		return "Contact [pidx=" + pidx + ", pbname=" + pbname + ", pbnumber=" + pbnumber + ", pbaddr=" + pbaddr
				+ ", pbemail=" + pbemail + ", pbmajor=" + pbmajor + ", pbyear=" + pbyear + ", pbcompany=" + pbcompany
				+ ", pbjob=" + pbjob + ", pbcafename=" + pbcafename + ", pbnickname=" + pbnickname + "]";
	};

}
