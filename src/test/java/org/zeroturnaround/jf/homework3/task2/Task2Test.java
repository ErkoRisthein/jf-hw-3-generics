package org.zeroturnaround.jf.homework3.task2;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Task2Test {

	@Test
	public void returnsEmptyListWithCalledWithNullList() {
		assertThat(Task2.unique((List<Integer>) null), is(emptyList()));
	}

	@Test
	public void returnsEmptyListWithCalledWithNullArray() {
		assertThat(Task2.unique((List<Integer>[]) null), is(emptyList()));
	}

	@Test
	public void returnsEmptyListWhenCalledWithEmptyList() {
		assertThat(Task2.<Integer>unique(emptyList()), is(emptyList()));
	}

	@Test
	public void returnsListWithOneElement() {
		assertThat(Task2.unique(singletonList(1)), is(singletonList(1)));
	}

	@Test
	public void returnsListWithTwoElementsFromOneList() {
		assertThat(Task2.unique(asList(1, 2)), is(asList(1, 2)));
	}

	@Test
	public void returnsListWithTwoElementsFromTwoLists() {
		assertThat(Task2.unique(singletonList(1), singletonList(2)), is(asList(1, 2)));
	}

	@Test
	public void detectsDuplicatesFromOneList() {
		assertThat(Task2.unique(asList(1, 1)), is(singletonList(1)));
	}

	@Test
	public void detectsDuplicatesFromTwoLists() {
		assertThat(Task2.unique(singletonList(1), singletonList(1)), is(singletonList(1)));
	}

	@Test
	public void worksWithOtherDataTypes() {
		assertThat(Task2.unique(singletonList("a"), singletonList(1)), is(asList("a", 1)));
	}

	@Test
	public void keepsElementOrder() {
		assertThat(Task2.unique(asList("a", "a", "b"), asList(1, 1, 2)), is(asList("a", "b", 1, 2)));
	}

}
