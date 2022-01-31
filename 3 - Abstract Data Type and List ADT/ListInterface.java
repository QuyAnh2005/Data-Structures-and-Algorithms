package AbstractDataTypeandListADT;

public interface ListInterface<T> extends Iterable<T>{
	
	public void add(T data); 	//Thêm phần tử vào danh sách
	
	public T get(int i); 	//Lấy giá trị phần tử thứ i
	
	public void set(int i, T data); 	//Đặt data vào vị trí i của danh sách
	
	public void remove(T data); 	//Loại phần tử data khỏi danh sách
	
	public boolean isContain(T data); 	//Kiểm tra phần tử data có trong danh sách
	
	public int size(); 	//Kích thước danh sách
	
	public boolean isEmpty(); 	//Danh sách có rỗng hay không
}
