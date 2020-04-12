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


### **설치/빌드**

 1. aws openJDK11 설치 (수동설치 방법)
    <pre><code>wget https://corretto.aws/downloads/latest/amazon-corretto-11-x64-linux-jdk.tar.gz
    
    tar zxvf amazon-corretto-11-x64-linux-jdk.tar.gz
    
    mv amazon-corretto-11.0.6.10.1-linux-x64 /usr/local/
    
    파일 생성  
    vi /etc/profile.d/jdk11.sh
    
    환경변수 설정  
    export JAVA_HOME=/usr/local/amazon-corretto-11.0.6.10.1-linux-x64
    export PATH=$PATH:$JAVA_HOME/bin
    </code></pre>
    * 참고 : https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/generic-linux-install.html

 2. maven설치  
    <pre><code>sudo yum install maven
    </code></pre>
    * 참고 : http://maven.apache.org/install.html

 3. 깃설치   
    <pre><code>sudo yum install git
    </code></pre>
 4. 소스 받기  (소스를 저장할 위치로 이동)
    <pre><code>git clone https://github.com/jiha-liz/shortener.git
    </code></pre>

 5. 소스 빌드 
    <pre><code>cd shortener
    해당 위치에  pom.xml이 있는지 획인
    
    sudo mvn package  
    
    java -jar target/shortener-1.0-SNAPSHOT.jar  
    </code></pre>

 6. 서비스 확인
    <pre>
    http://localhost
    or
    http://localhost/main
    </pre>