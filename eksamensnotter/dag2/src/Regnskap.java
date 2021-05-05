import java.util.*;

public class Regnskap {

    private List<Integer> realList = new ArrayList<Integer>();
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    private PriorityQueue<Integer[]> minHeap2 = new PriorityQueue<>(500,new Comparator<Integer[]>() {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[1] - o2[1];
        }
    });
    private List<Integer[]> deque = new ArrayList<>();

    public void nyLinje(int verdi) {
        this.realList.add(verdi);
    }

    public List<Integer> alleLinjer4() {
        int sum = 0;
        int i = 0;
        while (i < realList.size()) {
            int ele = realList.get(i);
            if (ele < 0) {
                boolean added = false;
                for (int j=0; j<deque.size(); j++) {
                    if (deque.get(j)[1] >= ele) {
                        deque.add(j, new Integer[]{i, ele});
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    deque.add(new Integer[]{i, ele});
                }
                if (deque.size() > 50) {
                    deque.remove(50);
                }

            }
            sum += ele;
            if (sum < 0) {
                Integer[] value = deque.remove(0);
                realList.remove((int)value[0]);
                sum -= value[1];
                deque.stream().filter(x -> x[0] > value[0]).forEach(x -> x[0]--);
            } else {
                i++;
            }
        }
        return realList;
    }

    public List<Integer> alleLinjer3() {
        int sum = 0;
        int i = 0;
        while (i < realList.size()) {
            int ele = realList.get(i);
            if (ele < 0) {
                minHeap2.add(new Integer[]{i, ele});
            }
            sum += ele;
            if (sum < 0) {
                Integer[] value = minHeap2.poll();
                realList.remove((int)value[0]);
                sum -= value[1];
                minHeap2.stream().filter(x -> x[0] > value[0]).forEach(x -> x[0]--);
            } else {
                i++;
            }
        }
        return realList;
    }


    public List<Integer> alleLinjer()  {
        int sum = 0;
        int i=0;
        while(i<realList.size()){
            int ele = realList.get(i);
            if (ele < 0) {
                minHeap.add(ele);
            }
            sum += ele;
            if (sum < 0) {
                Integer revomve_ele = Objects.requireNonNull(minHeap.poll());
                if (!realList.remove(revomve_ele)) {
                  i++;
                }
                sum -= revomve_ele;
            } else {
                i++;
            }
        }
        return realList;
    }

    public List<Integer> alleLinjer2(){
        return addNumber(new ArrayList<>(), 0, 0);
    }



    private List<Integer> addNumber(List<Integer> oldList, int index, int sum) {
        if (index >= realList.size()) {
            return oldList;
        }
        List<Integer> notAdded = addNumber(oldList, index + 1, sum);
        List<Integer> added = new ArrayList<>(oldList);
        int ele = realList.get(index);

        if (sum + ele >= 0) {
            sum += ele;
            added.add(realList.get(index));
            added = addNumber(added, index + 1, sum);
            if (added.size() > notAdded.size()) {
                return added;
            }
        }
        return notAdded;
    }

    public static void main(String[] args) throws Exception {
        Regnskap r = new Regnskap();
        // -3, 8, -4, -5, 4, -2, -3, -2, -2, 5, -6, 2, -5, -5
        System.out.println(r.alleLinjer());
        r.nyLinje(-3);
        r.nyLinje(8);
        r.nyLinje(-4);
        r.nyLinje(-5);
        r.nyLinje(4);
        r.nyLinje(-2);
        r.nyLinje(-3);
        r.nyLinje(-2);
        r.nyLinje(-2);
        r.nyLinje(5);
        r.nyLinje(-6);
        r.nyLinje(2);
        r.nyLinje(-5);
        r.nyLinje(-5);

        System.out.println(r.alleLinjer2());
        System.out.println(r.alleLinjer());

        Regnskap r2 = new Regnskap();
        Random random = new Random(2);
        for (int i=0; i < 200000; i++){
            r2.nyLinje(random.nextInt(100000) - random.nextInt(100000));
        }
        System.out.println("finnished adding numbers");
        long time = System.currentTimeMillis();
        List<Integer> lst = r2.alleLinjer();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
        for(int i=0; i<lst.size()+1; i++) {
            if(lst.subList(0, i).stream().mapToInt(x -> x).sum() < 0) {
                System.out.println("NIGGA");
            }
        }
    }


}