package jdbc2;

public class TimeDAOImpl implements TimeDAO {
	
	// �̷��� ����ִ°� ���� �����ս��� ����. 
	private static final String query = "select sysdate from dual";
	
	@Override
	public String getTime() throws Exception {
		
		final StringBuilder builder = new StringBuilder();
		// final�� �� ��ü�� �����Ǵ� ���� �ƴ϶�, ���빰�� �����Ǵ� ���̴�. 
		// ���ڿ��� immutable �� �� ���� �����Ǹ� �ٲ��� �ʴ´�. 
		// final �� <List>�� ������ List�� ���� �߰��ϴ� ���� ������ 
		
		new SqlAgent(){
			@Override
			protected void doJob() throws Exception{
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				rs.next();
			}
		}.doExecute();
		// TODO Auto-generated method stub
		return builder.toString();
	}

}