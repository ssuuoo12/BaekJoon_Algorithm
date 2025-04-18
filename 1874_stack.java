import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack; 

public class Main {
	
	 public static void main(String[] args) throws IOException {
		 
	        // BufferedReader: Scanner보다 빠른 입력을 위한 클래스
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        // StringBuilder: 문자열을 효율적으로 연결하기 위한 클래스
	        StringBuilder sb = new StringBuilder();
	        
	        // 첫 줄에서 정수 n 입력받기(수열의 길이)
	        int n = Integer.parseInt(br.readLine());
	        
	        // 스택 생성
	        Stack<Integer> stack = new Stack<>();
	        int current = 1; // 스택에 넣을 다음 숫자(오름차순으로 push)
	        
          // 코드에서는 처음에 isPossible을 true로 초기화하고(즉, "만들 수 있다"고 가정)
          // 불가능한 상황을 발견하면 false로 변경
	        boolean isPossible = true;
	        
	        // n개의 숫자에 대해 반복
	        for (int i = 0; i < n; i++) {
	            // 목표 숫자 입력받기(현재 만들어야 할 수열의 숫자)
	            int target = Integer.parseInt(br.readLine());
	            
	            // 현재 숫자가 목표 숫자보다 작거나 같을 때까지 스택에 push
	            while (current <= target) {
	                stack.push(current++); // 스택에 현재 숫자 넣고 current 1 증가
	                sb.append("+\n");      // push 연산 기록(+)
	            }
	            
	            // 스택의 맨 위 숫자가 목표 숫자와 같은지 확인
	            if (!stack.isEmpty() && stack.peek() == target) {
	                // peek(): 스택의 맨 위 요소를 확인(제거하지 않음)
	                stack.pop(); // 스택에서 숫자 꺼내기
	                sb.append("-\n"); // pop 연산 기록(-)
	            } else {
	                // 불가능한 경우: 스택 맨 위 숫자가 목표 숫자와 다름
	                isPossible = false;
	                break;
	            }
	        }
	        
	        // 결과 출력
	        if (isPossible) {
	            System.out.print(sb); // 가능한 경우 push/pop 연산 순서 출력
	        } else {
	            System.out.println("NO"); // 불가능한 경우 NO 출력
	        }
	    }
}