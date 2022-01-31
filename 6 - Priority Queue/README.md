# HƯỚNG DẪN CHẤM BÀI

Bài này mình làm theo combo 1 gồm: 
- Bài 1 
- Bài 2 
- Bài 3 

và một chút của bài 4 nhé!

## BÀI 1

Phần này nằm trong `package PriorityQueue.Exercise1`

- 1.1: UnsortedArrayPriorityQueue.java
- 1.2: SortedArrayPriorityQueue.java
- 1.3: UnsortedLinkedPriorityQueue.java
- 1.4: SortedLinkedPriorityQueue.java
- 1.5: Test.java

## BÀI 2

Phần này nằm trong `package PriorityQueue.Exercise2` và chỉ có một `class` duy nhất

## BÀI 3

Phần này nằm trong `package PriorityQueue.Exercise3`. Class đánh giá các thuật toán là `Compare.java`.

**Nhận xét:**
Có thể thấy, khi mà kích thước mẫu tăng lên thì độ hiệu quả các thuật toán cũng rõ rệt hơn. Qua nhiều lần chạy (với kích thức mẫu nhỏ hơn 1.000.000 phần tử) thì Quick Sort đang tỏ ra ưu thế vượt trội. Cụ thể, với mẫu ngẫu nhiên, thứ hạng về hiệu quả các thuật toán có thể sắp xếp như sau:

- 1. Quick Sort
- 2. Merge Sort
- 3. Heap Sort
- 4. Selection Sort 

## BÀI 4

Bài này mình mới viết code để chạy, nhưng máy hơi yếu nên không chạy được các mẫu có kích thước cực lớn. Bạn nào hứng thú thì có thể dụng code này để chạy thử hoặc đổi sang đa luồng để chạy!!

##### NOTE: `package Utils` xây dựng một lớp tạo mảng ngẫu nhiên để thuận tiện cho việc thao tác với mảng trong bài 3 và bài 4.
