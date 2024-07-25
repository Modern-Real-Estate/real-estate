# Real-Estate System

## Nguồn cảm hứng để Win Nguyen triển khai dự án này !
<i>Từ xa xưa trong quan niệm của người Việt ta thì việc “an cư lạc nghiệp” là rất quan trọng. Mua đất là đầu tư an toàn và chắc chắn nhất. Đất chẳng thể mất đi và cũng chẳng thể đẻ thêm nên nếu không tăng giá thì cũng giảm rủi ro về sau. Điều quan trọng, khi sở hữu nhà đất, bạn không lo lắng về việc mất tiền thuê nhà hàng tháng. Nhờ đó số tiền kiếm được sẽ dễ tích lũy để sử dụng cho nhu cầu sinh hoạt và kinh doanh hàng tháng. Ở những vùng nông thôn đang trong quá trình thay đổi cơ sở hạ tầng làm giá đất tăng nhanh chóng. Điều này làm cho các hộ gia đình trong khu quy hoạch nhanh chóng trở nên giàu có. Nhiều người có thể mua nhà, mua xe ngay sau khi bán đất. Không thiếu các câu chuyên trên báo chí người dân phất lên nhờ bán đất. Điều này khiến không chỉ người dân địa phương mà còn thu hút rất nhiều nhà đầu tư "săn đất". Ai cũng mong một ngày giá đất tăng mạnh để đổi đời. Hơn nữa cơn sốt bất động sản đang là xu thế của những quốc gia đang phát triển như Việt Nam...</i>
###  Và để nắm bắt điều đó Win Nguyen quyết định triển khai dự án này tạo ra một hệ thống quản lý mua bán cho thuê bất động sản với tên gọi Win Nguyen Company với SLOGAN: KHÁCH HÀNG LÀ NHẤT CHÚNG TÔI PHỤC VỤ BẰNG CẢ CON TIM :3
Quý Khách hàng đến với Win Nguyen Company không cần lo lắng về thủ tục hay chính sách ngộ đãi chỉ cần mang tâm thế mua/thuê nhà đất chúng tôi sẽ lo mọi thủ tục từ A -> Z và chính sách chăm sóc ưu tiên khách hàng nhất ! ♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤From: :3 Win Nguyen Company

## Inspiration for Win Nguyen to Launch This Project !
<i>From ancient times, the Vietnamese have held the belief that "settling down leads to career success." Buying land is considered the safest and most secure investment. Land cannot be lost or created, so if it doesn't appreciate, it at least reduces future risks. Importantly, when owning property, you don't worry about monthly rent expenses. This allows the money earned to be saved more easily for monthly living and business needs.
In rural areas undergoing infrastructure changes, land prices are rising rapidly. This has made families in planned zones wealthy quickly. Many people can afford to buy houses and cars right after selling land. There are numerous stories in the media about people getting rich by selling land. This attracts not only local residents but also many investors looking for land. Everyone hopes for a day when land prices soar to transform their lives. Moreover, the real estate boom is a trend in developing countries like Vietnam.</i>

### To seize this opportunity, Win Nguyen decided to launch this project to create a real estate buying, selling, and rental management system named WinNguyen Company with the SLOGAN: CUSTOMERS FIRST, WE SERVE WITH OUR HEART :3
Customers coming to Win Nguyen Company need not worry about procedures or special policies. They just need to have the intention to buy/rent property, and we will handle all the procedures from A to Z with the best customer care policies ! ♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤♡ ♥💕❤From: :3 Win Nguyen Company

## Logic Nghiệp vụ của dự án này
## Tiếng Việt
1/ Relationship of Customer <--> User.<br/>
Customer đi đến công ty môi giới bất động sản Win Nguyen Company để được tư vấn mua/thuê Building.
Sau đó, User(với role ADMIN/MANAGER) sẽ điều phối vài nhân viên User(với role STAFF) để chăm sóc (AssignmentCustomer) khách hàng đấy.
Trong quá trình chăm sóc thì giữa nhân viên và khác hàng sẽ có những giao dịch như (Transaction Type: Đặt cọc, buổi tư vấn, chốt đơn) (Khi khác hàng chốt đơn sẽ khởi tạo hợp đồng(Contract) ), lý do lưu thông tin chi tiết như vậy là để tracking history trả lương xứng đáng cho từng nhân viên khi khách hàng chốt đơn, đối với Transaction Type chốt đơn và đặc cọc sẽ được tra cứu để tổng kết nhân viên xuất sắc trong tháng.
<br/>
2/ Relationship of Customer <--> Building.<br/>
Khi những khác hàng đã được tư vấn và chốt đơn Building thành công sẽ khởi tạo hợp đồng (Contract) với Building đó.
Hợp đồng sẽ có nhiều loại như "Mua"/"Thuê", trạng thái hợp đồng "Hoàn tất thanh toán", "Trả góp" và sẽ có một số điều khoảng (Constract Terms) như quy định sử dụng - chính sách đổi trả - bảo hiểm toà nhà - hủy hợp đồng do bên môi giới hoặc khách hàng).
Những khác hàng đã "chốt đơn"/"khởi tạo hợp đồng" với toàn nhà đó thì có quyền đánh giá(Review) BUilding đó.<br/>
3/ Relationship of User <--> Building.<br/>
ADMIN/MANAGER điều phối vài nhân viên làm việc với một Building trong đó có một người sẽ là Manager của toàn nhà, và mọi dịch vụ của khác hàng với ngôi nhà này sẽ do nhóm nhân viên này phụ trách.
<br/>
4/ Những thuộc tính là khóa ngoại xoay quanh Building.<br/>
RentArea một toà nhà sẽ có nhiều diện tích thuê khu vực thuê (hoặc mua).
District một toàn nhà sẽ chỉ nằm trên 1 huyện (trường hợp tòa nhà nằm trên đất 2 huyện thì tính phần đất ở huyện nào nhiều hơn).
BuildingType nhà có tần trệt, có nội thất, nhà nguyên căn, nhà thương mại, nhà công vụ hoặc nhà phân cấp...<br/>
5/ Coming soon...<br/>

6/ Tính năng bên lề...<br/>

Realtime communication: <br/>
Upload file/ảnh:<br/>
Payment:<br/>
Coming soon...<br/>

## Mô hình sơ đồ của cả dự án 
Coming soon...

## Những công nghệ được sử dụng trong dự án và chức năng nổi bật
Coming soon...

## Tổng quan về APIs của cả dự án
Coming soon...

## Video demo
Coming soon...

## Làm sao để sử dụng dự án này ?
Coming soon...

### Prerequisites
  You should have the below softawares installed in your pc :
  * JDK 21 and JRE
  * MySQL
  * and your preferred IDE or text editor
### Getting Started
Coming soon...

### Installation
Coming soon...
