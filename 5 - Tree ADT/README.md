# HƯỚNG DẪN CHẤM BÀI 
### Bài này mình làm theo 2 combo trong số các combo bài tập là:
- Combo 1: Bài 1, Bài 2
- Combo 2: Bài 2, Bài 3

## Bài 1
### 1.1
Nội dung bài tập này nằm trong file **ArrayBinaryTree.java**

### 1.2
Nội dung bài tập này nằm trong file **LinkedBinaryTree.java**

### 1.3
Bài tập này được gói gọn trong hai phương thức tại mỗi đối tượng tương ứng là **ArrayBinaryTree**, **LinkedBinaryTree**. Cụ thể:
- phương thức **visualize()** để in ra cây nhị phân trên màn hình
- phương thức **writeFile()** để in ra cây nhị phân ra file 

#### NOTE: 
Hiện tại, mình đang sử dụng file in ra với đường dẫn như sau:

`String fileName = "src/TreeADT/treeToArray.txt";`

Nếu bạn gặp lỗi về không có đường dẫn thì chỉnh lại đường dẫn của `fileName` cho phù hợp mới máy của mình. 

Mọi người chạy hàm `main` trong file mục `1.1` và `1.2` để thấy được kết quả nhé! Nếu sau khi chạy, các bạn không thấy các các file `treeToArray.txt` và 
`treeToLinked.txt` thì mở trực tiệp thư mục trên máy theo hướng dẫn sau:
- Bước 1: Tìm đến thư mục của eclipse trên máy tính, thường là `eclipse-workspace`
- Bước 2: Tìm đến thư mục của package hiện tại là `TreeADT`. Tại đây bạn sẽ thấy được hai file ở trên.

## Bài 2
### 2.1
Nội dung bài tập này nằm hoàn toàn trong file **ExpressionTree.java**

### 2.2
Được thực hiện tại hàm `main` của `2.1`.

### 2.3

Sử dụng các hàm tại `main` của `2.1`. Cụ thể:
- toDouble(String node): chuyển các số dạng chuỗi của các `node` về kiểu `double`
- oper2calculate(String operator, double leftValue, double rightValue): tính toán các `node` con, với root là một toán tử 
- compute(Node<String> root): tính toán biểu thức toán học đầu vào 

## Bài 3
- Nội dung bài tập này nằm trong file **BuildTree.java**
- Chuỗi input vào thì mỗi kí tự phải cách nhau một dấu cách, chẳng hạn `exp = "( 6 / 3 + 2 ) * ( 7 - 4 )"`