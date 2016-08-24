package anaydis.sort.exercise3;

import anaydis.sort.Sorter;
import anaydis.sort.SorterType;
import anaydis.sort.data.StringDataSetGenerator;
import anaydis.sort.provider.SorterProvider;
import anaydis.sort.provider.SorterProviderImpl;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by isabel on 8/23/16.
 */
public class FullNameSortTest {

    @Test
    public void testFullNameBubble() {

        final List<FullName> original = new ArrayList<>(10);

        StringDataSetGenerator generator = new StringDataSetGenerator();
        List<String> names = new ArrayList<>(generator.createRandom(10));
        List<String> surnames = new ArrayList<>(generator.createRandom(10));
        //original.add(new FullName(names.get(0), surnames.get(0)));
        for(int i = 0; i < names.size(); i++){
            original.add(new FullName(names.get(i), surnames.get(i)));
        }

        /*
        List<FullName> original = Arrays.asList(new FullName("Paula", "Alonso"), new FullName("Diego", "Diaz"),
                new FullName("Diego", "Alonso"));
*/
        final List<FullName> copy = new ArrayList<>(original);
        final SorterProvider provider = new SorterProviderImpl();
        final Sorter bubble = provider.getSorterForType(SorterType.BUBBLE);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        }, copy);


        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        });
        ;


        assertThat(copy).containsExactlyElementsOf(original);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        }, copy);

        // Sort original with java collections
        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        });
        ;
        for(FullName name : copy){
            System.out.println(name.getFirstname() + " " + name.getLastname());
        }
        // Assert correctly sorted
        assertThat(copy).containsExactlyElementsOf(original);

    }

    @Test
    public void testFullNameSelection() {

        final List<FullName> original = new ArrayList<>(10);

        StringDataSetGenerator generator = new StringDataSetGenerator();
        List<String> names = new ArrayList<>(generator.createRandom(10));
        List<String> surnames = new ArrayList<>(generator.createRandom(10));
        //original.add(new FullName(names.get(0), surnames.get(0)));
        for(int i = 0; i < names.size(); i++){
            original.add(new FullName(names.get(i), surnames.get(i)));
        }

        /*
        List<FullName> original = Arrays.asList(new FullName("Paula", "Alonso"), new FullName("Diego", "Diaz"),
                new FullName("Diego", "Alonso"));
*/
        final List<FullName> copy = new ArrayList<>(original);
        final SorterProvider provider = new SorterProviderImpl();
        final Sorter bubble = provider.getSorterForType(SorterType.BUBBLE);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        }, copy);

        // Sort original with java collections
        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        });
        ;

        // Assert correctly sorted
        assertThat(copy).containsExactlyElementsOf(original);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        }, copy);

        // Sort original with java collections
        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        });
        ;
        for(FullName name : copy){
            System.out.println(name.getFirstname() + " " + name.getLastname());
        }
        // Assert correctly sorted
        assertThat(copy).containsExactlyElementsOf(original);

    }

    @Test
    public void testFullNameInsertion() {

        final List<FullName> original = new ArrayList<>(10);

        StringDataSetGenerator generator = new StringDataSetGenerator();
        List<String> names = new ArrayList<>(generator.createRandom(10));
        List<String> surnames = new ArrayList<>(generator.createRandom(10));
        //original.add(new FullName(names.get(0), surnames.get(0)));
        for(int i = 0; i < names.size(); i++){
            original.add(new FullName(names.get(i), surnames.get(i)));
        }

        /*
        List<FullName> original = Arrays.asList(new FullName("Paula", "Alonso"), new FullName("Diego", "Diaz"),
                new FullName("Diego", "Alonso"));
*/
        final List<FullName> copy = new ArrayList<>(original);
        final SorterProvider provider = new SorterProviderImpl();
        final Sorter bubble = provider.getSorterForType(SorterType.BUBBLE);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        }, copy);

        // Sort original with java collections
        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getFirstname().compareTo(name2.getFirstname());
            }
        });
        ;

        // Assert correctly sorted
        assertThat(copy).containsExactlyElementsOf(original);
        bubble.sort(new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        }, copy);

        // Sort original with java collections
        Collections.sort(original, new Comparator<FullName>() {
            @Override
            public int compare(FullName name1, FullName name2) {
                return name1.getLastname().compareTo(name2.getLastname());
            }
        });
        ;
        for(FullName name : copy){
            System.out.println(name.getFirstname() + " " + name.getLastname());
        }
        // Assert correctly sorted
        assertThat(copy).containsExactlyElementsOf(original);

    }
}

