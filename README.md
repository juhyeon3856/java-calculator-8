[//]: # (# java-calculator-precourse)

# 🧮 java-calculator-8

문자열 덧셈 계산기 구현 과제
> 입력받은 문자열에서 숫자를 추출하고, 지정된 구분자로 합계를 계산하는 프로그램입니다.

---

## 🚀 실행 방법

### 1. 실행 명령어

```bash
./gradlew run
````

혹은 IntelliJ에서
`Application.java` → `main()` 실행

### 2. 입력 예시

```
1,2:3
```

### 3. 출력 예시

```
결과 : 6
```

---

## 🧩 주요 기능

| 클래스                                                                       | 역할                               |
|---------------------------------------------------------------------------|----------------------------------|
| [`Application.java`](src/main/java/calculator/Application.java)           | 프로그램의 진입점 (Main)                 |
| [`AddRequest.java`](src/main/java/calculator/AddRequest.java)             | 사용자 입력 처리 및 유효성 검증               |
| [`AddCalculator.java`](src/main/java/calculator/AddCalculator.java)       | 숫자 계산 로직 수행 (합산 처리)              |
| [`DivisionIndexDto.java`](src/main/java/calculator/DivisionIndexDto.java) | 커스텀 구분자(`// ~ \n`) 인덱스 구간 관리 DTO |

---

## ⚙️ 구현 상세

### 1️⃣ 커스텀 구분자 처리

* 입력값이 `//`와 `\n` 사이에 있을 경우 이를 커스텀 구분자로 인식
* 예:

  ```
  //;\n1;2;3
  결과: 6
  ```

### 2️⃣ 입력값 유효성 검사

* 숫자와 구분자 이외의 문자가 포함되면 예외 발생
* 구분자 문자열에 숫자가 포함되면 예외 발생
* 빈 문자열이나 `null` 입력도 예외 처리

### 3️⃣ 계산 로직

* 문자열을 구분자 기준으로 분리 후 `int`로 변환하여 합산
* Stream API를 사용해 간결하게 구현 (`Arrays.stream(...).mapToInt(...).sum()`)

---

## 🧠 예외 처리

| 예외 클래스           | 발생 조건                             |
|------------------|-----------------------------------|
| `InputException` | 잘못된 입력 (빈 문자열, 잘못된 구분자, 비숫자 입력 등) |

---

## 🧪 실행 예시

| 입력             | 출력  | 설명          |
|----------------|-----|-------------|
| `"1,2,3"`      | `6` | 기본 구분자 `,`  |
| `"1:2:3"`      | `6` | 기본 구분자 `:`  |
| `"//;\n1;2;3"` | `6` | 커스텀 구분자 `;` |
| `"//#\n1#2#3"` | `6` | 커스텀 구분자 `#` |
| `"//;\n1;2,a"` | 예외  | `a`는 숫자가 아님 |

---

## 📂 디렉터리 구조

```
src
└── main
    └── java
        └── calculator
            ├── Application.java        # 프로그램 시작점
            ├── AddRequest.java         # 입력 및 검증
            ├── AddCalculator.java      # 계산 로직
            ├── DivisionIndexDto.java   # 커스텀 구분자 인덱스 관리
```

---

## 🧑‍💻 개발 메모

* Java Stream을 적극 활용하여 명확한 로직 구성
* 정규표현식으로 입력 검증 강화
* 예외 발생 시 사용자 친화적인 메시지 제공 (`InputException`)
* 클래스별 역할 분리로 단일 책임 원칙(SRP) 준수

---

## 📜 출제 요구사항

### 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.

> 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.

커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.

> 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

---

### 입출력 요구 사항

입력

> 구분자와 양수로 구성된 문자열

출력

> 덧셈 결과
>
> 결과 : 6


실행 결과 예시

> 덧셈할 문자열을 입력해 주세요.
>
> 1,2:3
>
> 결과 : 6


---

### 프로그래밍 요구 사항

JDK 21 버전에서 실행 가능해야 한다.

프로그램 실행의 시작점은 Application의 main()이다.

build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.

프로그램 종료 시 System.exit()를 호출하지 않는다.

프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

자바 코드 컨벤션을 지키면서 프로그래밍한다.

기본적으로 Java Style Guide를 원칙으로 한다.

---

### 라이브러리

camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.

사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

---

### Git Commit Message Conventions

https://gist.github.com/stephenparish/9941e89d80e2bc58a153

### Java Style Guide

https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java

### Cleancode

https://github.com/woowacourse/woowacourse-docs/blob/main/cleancode/pr_checklist.md