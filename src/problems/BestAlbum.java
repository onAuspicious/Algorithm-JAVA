package problems;

import java.util.*;

public class BestAlbum {

    static class Song implements Comparable<Song> {
        int num;
        int play;
        public Song (int num, int play) {
            this.num = num;
            this.play = play;
        }

        @Override
        public int compareTo(Song s) {
            if (this.play > s.play) {
                return -1;
            } else if (this.play < s.play) {
                return 1;
            } else {
                return this.num - s.num;
            }
        }
    }

    static HashMap<String, ArrayList<Song>> map = new HashMap<>();
    static ArrayList<Song>[] songList;

    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;

        for (int i = 0; i < size; i++) {
            if (!map.containsKey(genres[i])) map.put(genres[i], new ArrayList<>());
            ArrayList list = map.get(genres[i]);
            list.add(new Song(i, plays[i]));
        }

        songList = new ArrayList[map.size()];
        int j = 0;
        for (String key : map.keySet()) {
            songList[j] = map.get(key);
            j++;
        }

        Arrays.sort(songList, new Comparator<ArrayList<Song>>(){
            @Override
            public int compare(ArrayList<Song> s1, ArrayList<Song> s2) {
                int sum1 = 0, sum2 = 0;
                for (Song s :s1) {
                    sum1 += s.play;
                }
                for (Song s : s2) {
                    sum2 += s.play;
                }
                return sum2 - sum1;
            }
        });

        ArrayList<Integer> result = new ArrayList<>();

        for (ArrayList<Song> s : songList) {
            Collections.sort(s);
            for (int i = 0; i < s.size(); i++) {
                if (i > 1) break;
                result.add(s.get(i).num);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
