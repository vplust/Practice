package practice.algorithms.greedy.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given set of jobs each job can be completed in unit time. Profit associated
 * with job is credited if job finished before deadline. Find maximum profit
 * 
 * @author Vikas
 *
 */
public class JobSequencingProblem {
	public static class Job {
		String id;
		int deadline;
		int profit;

		public Job(String id, int deadline, int profit) {
			// TODO Auto-generated constructor stub
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Job> jobs = Arrays.asList(new Job("a", 2, 100), new Job("b", 1, 19), new Job("c", 2, 27),
				new Job("d", 1, 25), new Job("e", 3, 15));

		String result[] = new String[3];
		// Sort descending by profit & fill based on duration backwards
		jobs.stream().sorted((a, b) -> b.profit - a.profit).forEach(a -> {
			for (int i = a.deadline - 1; i >= 0; --i) {
				if (result[i] == null) {
					result[i] = a.id;
					break;
				}
			}
		});
		System.out.println(Arrays.asList(result));

	}

}
