package practice.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ActivitySelectionProblem {

	static class Activity{
		private int startTime;
		private int endTime;
	
		public Activity(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		public int getStartTime(){
			return this.startTime;
		}
		
		public int getEndTime(){
			return this.endTime;
		}
		
		public String toString(){
			return getStartTime()+"-"+getEndTime()+" ";
		}
	}
	public static void main(String[] args) {
		List<Activity> activities = new ArrayList<>();
		Random random = new Random();
		for(int i=0;i<10;++i){
			int start = random.nextInt(50);
			int end =0;
			while(end<start)
				end = random.nextInt(50);
			activities.add(new Activity(start,end));
		}

		System.out.println(activities); 
		
		//Sort by endtime
		activities.sort((a,b)->a.getEndTime()<b.getEndTime()?-1:1);
			
		System.out.println(activities.get(0));
		for(int i =1; i<activities.size();++i){
			if(activities.get(i-1).getEndTime()<=activities.get(i).getStartTime())  //Next activity is first after end time of previous activity
				System.out.println(activities.get(i));
		}
	}

}
