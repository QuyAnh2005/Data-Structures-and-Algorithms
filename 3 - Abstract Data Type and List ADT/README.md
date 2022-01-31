# HƯỚNG DẪN CHẤM BÀI 
## Bài 1
- Các file: Complex.java 
- Tự đề xuất một ứng dụng sử dụng kiểu dữ liệu đã tạo: Dùng để xây dựng chương trình máy tính bỏ túi 

## Bài 2
- Các file: 
    - Shape.java 
    - Circle.java 
    - Sphere.java 
    - Rectangle.java 
    - ShapeExamples.java : Để test các kiểu dữ liệu đã xây dựng 
- Tự đề xuất một ứng dụng sử dụng kiểu dữ liệu đã tạo: Dùng để tạo các chương trình game so sánh hình khối 

## Bài 3
- Các file:
    - ListInterface.java 
    - SimpleArrayList.java 

## Bài 4
- Các file: SimpleLinkedList.java 

## Bài 5
- Các file:
    - WordCountApplication.java 
    - big.txt : chứa dữ liệu để đếm từ
    
**Chú ý: ** 
Khi bạn thực hiện bài 5 mà gặp lỗi `java.io.FileNotFoundException: big.txt (No such file or directory)` thì kiểm tra lại xem bạn đang làm việc tại đâu bằng câu lệnh sau:

```java 
	String dir = System.getProperty("user.dir");
	System.out.println(dir);
```

và nếu được trả về như sau 

```
    >> /home/quyanh/eclipse-workspace/Data Structure and Algorithm
```

thì nghĩa là bạn đang ở thư mục `Data Structure and Algorithm` chứ chưa ở trong package `AbstractDataTypeandListADT`. 
Để khắc phục thì bạn chỉ cần chuyển file `big.txt` ra ngoài thư mục `Data Structure and Algorithm`, ngang hàng với `src` và `bin`. Cụ thể, cấu trúc thư mục của bạn lúc đó sẽ trông như sau:


```
	Data Structure and Algorithm
		bin
		src
			JavaReview
			...
			AbstractDataTypeandListADT
				Complex.java
				...
		big.txt
```