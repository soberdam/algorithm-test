import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
일단 순서대로 m개의 연속이므로 정렬을 하면 안된다.
슬라이딩 윈도우사용
덱(슬라이딩윈도우)에 가능성이 있는 최소/최대만 저장한다.
이를 위해 현재 삽입하는 값보다 덱에 있는 더 큰/작은 값들은 현재 삽입하는 값이 뽑히는 차례가 올 때까지 쓸 일이 없으므로 뽑는다. 
이후 지금 덱에 있는 맨 앞의 최소/최대의 인덱스가 왔을때 덱에서 뽑는다.
만약 없다면, none을 출력한다.
 */
class Sample {
	int index;
	int value;
	Sample(int index, int value) {
		this.index = index;
		this.value = value;
	}
}
public class Main {
	static int N, M, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		Deque<Sample> dequeMin = new ArrayDeque<>();
		Deque<Sample> dequeMax = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			
			if(!dequeMax.isEmpty()&&dequeMax.peekFirst().index==i-M) 
				dequeMax.pollFirst();
			
			
			if(!dequeMin.isEmpty()&&dequeMin.peekFirst().index==i-M) 
				dequeMin.pollFirst();
			
			
			while(!dequeMax.isEmpty()&&dequeMax.peekLast().value<value) dequeMax.pollLast();
			dequeMax.addLast(new Sample(i, value));
			while(!dequeMin.isEmpty()&&dequeMin.peekLast().value>value) dequeMin.pollLast();
			dequeMin.addLast(new Sample(i, value));
			
			if(i>=M-1) {
				if(dequeMax.peekFirst().value-dequeMin.peekFirst().value<=C) {
					sb.append(i+1-M+1).append('\n');
				}
			}
		}
		if (sb.length() == 0) {
			System.out.println("NONE");
		} else {
			System.out.println(sb.toString());
		}
	}

}
