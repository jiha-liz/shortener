# shortener
URL shortening

### **시나리오**

URL을 입력하면 8Character이내 결과(Shortening된 URL)를 리턴  
결과 URL 입력시 처음 입력한 URL로 리다이렉트 되어야함  

또한, 같은 URL을 입력할 경우 결과는 동일해야함  
같은 URL에 대한 요청수 정보를 노출


### **고민**

1. 어떤 알고리즘으로 결과를 만들지  
-> 항상 같은결과를 내려면 랜덤은 무리가 있음.. 디비를 이용해도.. 되긴하는데..   
-> 입력받은 URL을 아스키코드와 62진수를 통해 변환하고자 하였으나, 유니크 하지 않을 수 있음.  
-> *URL이라는 특성상 base64가 아닌 base62를 사용해야함*  
=> **URL을 저장할때 유니크한 키값을 따고, 키를 인코딩 하는 방안**  
 


2. 디비는 무엇을 쓸지  
 => **H2 사용**  

3. 구성.. ?  
-> spring boot, maven, jpa, thymeleaf, ... ?  
=> **spring boot, mabven, jpa, html, jquery**  
