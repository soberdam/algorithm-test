import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 2. 마을을 노드로, 마을간의 연결을 무방향 그래프라고 가정하자.
 * 2-1. 어떤 마을을 선택하면, 인접한 마을은 선택할 수 없다.
 * 2-2. 어떤 마을을 선택하지 않으면, 적어도 하나의 인접한 마을은 선택해야한다.
 * 2-2. dp로 top-down dfs로 내려가며 dp테이블에 n-1번째 노드 반환시 n번째 노드를 선택한 경우의 수와 선택하지 않은 경우의 수를 더해준다.
 * 2-3. dp[N][0] 은 N번째 마을을 선택하지 않았을 경우 주민 수(반드시 연결된 노드 하나 이상 선택), dp[N][1] 은 N번째 마을을 선택했을 때 주민 수(연결 노드를 반드시 선택하지 않아야)
 */

public class Main {
	static int dp[][];
	static ArrayList<ArrayList<Integer>> tree;
	static int[] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		// 2. 마을을 노드로, 마을간의 연결을 무방향 그래프라고 가정하자.
		tree = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		// 각 마을 번호에 해당하는 주민 수 저장
		people = new int [N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
				
		for(int i=1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree.get(from).add(to);
			tree.get(to).add(from);
		}
		dfs(1, 1);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	// 2-2. dp로 top-down dfs로 내려가며 dp테이블에 n-1번째 노드 반환시 n번째 노드를 선택한 경우의 수와 선택하지 않은 경우의 수를 더해준다.
	public static void dfs(int now, int start) {
		// 2-3. dp[N][0] 은 N번째를 선택하지 않았을 때 마을 주민의 수, dp[N][1] 은 N번째를 선택했을 때 마을 주민의 수
		dp[now][0] = 0;
		dp[now][1] = people[now];
		
//		2-1. 어떤 마을을 선택하면, 인접한 마을은 선택할 수 없다.
//		2-2. 어떤 마을을 선택하지 않으면, 적어도 하나의 인접한 마을은 선택해야한다.
		for(int i=0; i<tree.get(now).size(); i++) {
			int next = tree.get(now).get(i);
			if(next!=start) { // 출발한 노드로 돌아가지 않기 위한 조건
				dfs(next, now);
				// 현재 노드를 선택하지 않았을 때는 연결 노드를 (반드시)선택했을때의 합을 더해준다.
				// 이떄 모두 dp[next][0]을 선택한 경우 dp[now][1]과 같아지므로 현재노드를 선택한 경우와 최댓값이 같아진다.
				// 즉 now를 호출하는 함수에서 now[0]을 호출하든 now[1]을 호출하든 결과값은 같으므로 항상 마을이 인접한다.
				dp[now][0] += Math.max(dp[next][0], dp[next][1]);
				// 현재 노드를 선택했을 때는 연결 노드를 선택했을 때와 선택하지 않았을 때의 합중 최솟값을 더해준다.
				dp[now][1] += dp[next][0]; 
			}
		}
	
 	}

}
