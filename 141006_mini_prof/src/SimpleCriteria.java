
public class SimpleCriteria implements Criteria {
	private int page;
	private String[] type;
	private String keyword;
	
	public SimpleCriteria(int page, String[] type, String keyword) {
		super();
		this.page = page;
		this.type = type;
		this.keyword = keyword;
	}

	@Override
	public int getPage() {
		// TODO Auto-generated method stub
		// ���׿�����. 
		return this.page==0? 1: this.page;
	}

	@Override
	public int setPage(int page) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return this.keyword == null?"":this.keyword;
	}

	@Override
	public void setKeyword(String keyword) {
		// TODO Auto-generated method stub
		this.keyword =keyword;
	}

	@Override
	public String[] getTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
