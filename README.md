Để Login với google acount: 
1. https://console.cloud.google.com/apis/credentials?project=common-379008&supportedpurview=project
2. Click: CREATE CREDENTIALS -> chọn OAuth client ID
3. chọn Application type là: Web application
4. Name: tên dự án của bạn (có thể đặt tuỳ biến)
5. Authorized redirect URLs -> chọn ADD URI
6, Tại URIs nhập: http://localhost:6033/login/oauth2/code/google
   
tuỳ theo tên miền của bạn, ở đây tôi dùng trên máy localhost và port là 6033


==> mvn clean install -U  để cài GoogleOAuth2UserService
