# 1.1 초난감DAO

> 자바빈이란?

- 원래 비주얼 툴에서 조작 가능한 컴포넌트를 말함.
- 웹 기반으로 바뀌면서 그대로 명맥을 유지
- 다음 두가지 관례를 따르는 것을 자바빈이라고 함.
  - 디폴트 생성자: 툴이나 프레임워크에서 리플렉션 이용해서 오브젝트를 생성하기 때문
  - 프로퍼티

> **스프링을 공부한다는 것은?**

- 이 간단한 메소드를 이미 검증을 했다.
- 잘 동작하는 코드를 굳이 수정하고 개선하는 이유는 무엇일까?
- 이 코드를 개선했을때의 장점은 무엇일까?
- 그런 장점들이 당장에, 또는 미래에 주는 유익은 무엇인가?
- 객체지향 설계의 원칙과는 무슨 상관이 있을까?
- 이 코드를 개선하는 경우와 그대로 사용하는 경우 스프링을 사용하는 개발에서 무슨 차이가 있을까?

# 1.2 DAO 의 분리

## 디자인 패턴

### 템플릿 메소드 패턴

```java
public abstract class Super {

	public void templateMethod() {
		// 기본 알고리즘 코드
		hookMethod();
		abstractMethod();
		...	
	}

	protected void hookMethod() {} // -> 선택적으로 오버라이드 가능한 훅메소드
	public abstract void abstractMethod(); // -> 서브클래스에서 반드시 구현해야하는 추상메소드

}

public class Sub1 extends Super {

	@Override
	protected void hookMethod() {
		...
	}

	@Override
	public void abstractMethod() {
		...
	}
}
```
변하지 않는 기능은 슈퍼클래스에 만들어두고 선택적으로 오버라이드할 수 있는 메소드를 만들어두는 것을 템플릿 메소드 패턴이라고 한다.

### 팩토리 메소드 패턴

객체 생성에 대한 책임을 하위 클래스에 떠넘기는 것을 말한다.
```java
public abstract class Sub2 extends Super {

	public abstract FooInterface factoryMethod();
}
```
이때 Sub2 의 관심은 FooInterface 가 어떤 구현 객체인지 전혀 관심이 없다는 것이다.

참고로 객체를 생성하는 기능을 가진 메소드를 팩토리 메소드라고 하는데 패턴과는 혼동하지않도록 주의해야한다.
