package chocolatejar;

public interface  Jar {
	public int getItem();		// ������ ������ ��ȯ
	public void takeItem(int hand); 	//hand��ŭ�� �������� �̴´�
	public String status(); 		//������ ��Ȳ  ���
	public boolean isEmpty();		// ����ִ��� Ȯ��

}
