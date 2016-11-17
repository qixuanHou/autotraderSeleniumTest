package com.autotrader.mdot.utilities;

/**
 * Created by sacown on 9/3/2015.
 */
public class mDotElements {

    public enum Radius{ANY_DISTANCE(0),TEN_MILES(1),TWENTY_FIVE_MILES(2),FIFTY_MILES(3),SEVENTY_FIVE_MILES(4),ONE_HUNDRED_MILES(5),
        TWO_HUNDRED_MILES(6),THREE_HUNDRED_MILES(7),FIVE_HUNDRED_MILES(8);

        private int position;

        private Radius(int position){this.position = position;}
        public int getPosition(){
            return position;
        }
    }
    public enum moreOptions{KEYWORD(".keywords");

        private String option;

        moreOptions(String option) {this.option = option;}
        public String getOption(){return option;}

    }
}
