package Sorting;

import java.util.Comparator;

public class comparecard implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		if (o1.getRank()>o2.getRank())
			return 1;
		else if(o1.getRank()<o2.getRank())
			return -1;
		else {
			if (o1.getIndex()>o2.getIndex())
				return 1;
			if (o1.getIndex()<o2.getIndex())
				return -1;
		}
		return 0;
	}
	
}
