/*
 * Created on Sep 23, 2006
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2006-2011 the original author or authors.
 */
package org.fest.util;

import static org.fest.util.Collections.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Tests for
 * {@link ComparatorBasedComparisonStrategy#caseInsensitiveComparisonStrategy.duplicatesFrom(java.util.Collection)}.<br>
 * 
 * @author Joel Costigliola
 */
public class ComparatorBasedComparisonStrategy_duplicatesFrom_Test extends
    AbstractTest_ComparatorBasedComparisonStrategy {

  @Test
  public void should_return_existing_duplicates() {
    Iterable<?> duplicates = caseInsensitiveComparisonStrategy.duplicatesFrom(list("Merry", "Frodo", "Merry", "Sam",
        "FrODO"));
    assertEquals(2, sizeOf(duplicates));
    assertTrue(caseInsensitiveComparisonStrategy.iterableContains(duplicates, "frodo"));
    assertTrue(caseInsensitiveComparisonStrategy.iterableContains(duplicates, "MERRY"));
  }

  @Test
  public void should_not_return_any_duplicates() {
    Iterable<?> duplicates = caseInsensitiveComparisonStrategy.duplicatesFrom(list("Frodo", "Sam", "Gandalf"));
    assertTrue(isEmpty(duplicates));
  }

  @Test
  public void should_not_return_any_duplicates_if_collection_is_empty() {
    Iterable<?> duplicates = caseInsensitiveComparisonStrategy.duplicatesFrom(new ArrayList<String>());
    assertTrue(isEmpty(duplicates));
  }

  @Test
  public void should_not_return_any_duplicates_if_collection_is_null() {
    Iterable<?> duplicates = caseInsensitiveComparisonStrategy.duplicatesFrom(null);
    assertTrue(isEmpty(duplicates));
  }

}
