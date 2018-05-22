package org.learnwithllew.duplicationkata.tests;

import org.approvaltests.Approvals;
import org.junit.Test;
import org.learnwithllew.duplicationkata.Lesson1Straight;
import org.learnwithllew.duplicationkata.Lesson21;
import org.learnwithllew.duplicationkata.Lesson2Variable;
import org.learnwithllew.duplicationkata.Lesson31;
import org.learnwithllew.duplicationkata.Lesson3HigherOrderFunctions;

public class RegressionTest
{
  @Test
  public void testCat() throws Exception {
    Lesson1Straight song = new Lesson1Straight();
    song.singCatSong();
    Approvals.verify(song.song);
  }
  @Test
  public void testBeer() throws Exception {
    Lesson2Variable song = new Lesson2Variable();
    song.singBottlesOfBeer();
    Approvals.verify(song.song);
  }
  @Test
  public void testNames() throws Exception {
    Lesson21 song = new Lesson21();
    String[] names = {"Llewellyn", "Samatha", "Tomas", "Emilia"};
    song.singSong(1, names);
    song.singSong(2, names);
    song.singSong(3, names);
    Approvals.verify(song.song);
  }
  @Test
  public void testNumbers() throws Exception {
    Lesson3HigherOrderFunctions song = new Lesson3HigherOrderFunctions();
    song.singCheers();
    Approvals.verify(song.song);
  }
  @Test
  public void testNames3() throws Exception {
    Lesson31 song = new Lesson31();
    String[] names = {"Llewellyn", "Samatha", "Tomas", "Emilia"};
    song.singSong(1, names);
    song.singSong(2, names);
    song.singSong(3, names);
    Approvals.verify(song.song);
  }
}
