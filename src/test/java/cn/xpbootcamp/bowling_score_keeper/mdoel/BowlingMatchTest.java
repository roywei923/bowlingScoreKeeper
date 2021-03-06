package cn.xpbootcamp.bowling_score_keeper.mdoel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cn.xpbootcamp.bowling_score_keeper.model.BowlingMatch;
import org.junit.jupiter.api.Test;

public class BowlingMatchTest {

  @Test
  void should_have_round1_and_total_score_equal_first_throw_when_record_throw_given_it_is_round1_first_throw() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(7);

    // Assert
    assertEquals(7, match.getRoundScore(1));
    assertEquals(7, match.getTotalScore());
  }

  @Test
  void should_have_round1_and_total_score_equal_10_when_record_throw_given_round1_is_strike() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(10);

    // Assert
    assertEquals(10, match.getRoundScore(1));
    assertEquals(10, match.getTotalScore());
  }

  @Test
  void should_have_round1_and_total_score_equal_10_when_record_throw_given_round1_is_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(7);
    match.recordThrow(3);

    // Assert
    assertEquals(10, match.getRoundScore(1));
    assertEquals(10, match.getTotalScore());
  }

  @Test
  void should_have_round1_and_total_score_equal_9_when_record_throw_given_round1_is_not_strike_or_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(7);
    match.recordThrow(2);

    // Assert
    assertEquals(9, match.getRoundScore(1));
    assertEquals(9, match.getTotalScore());
  }

  @Test
  void should_have_round1_equal_10_plus_round2_score_and_total_score_equal_2times_round2_score_plus_10_when_record_throw_given_round1_strike_and_round2_not_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(10);
    match.recordThrow(8);
    match.recordThrow(1);

    // Assert
    assertEquals(10 + 9, match.getRoundScore(1));
    assertEquals(2 * 9 + 10, match.getTotalScore());
  }

  @Test
  void should_have_round1_equal_10_plus_round2_first_throw_and_total_score_equal_round1_score_plus_round2_throws_when_record_throw_given_round1_spare_and_round2_not_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(5);
    match.recordThrow(5);

    match.recordThrow(8);
    match.recordThrow(1);

    // Assert
    assertEquals(10 + 8, match.getRoundScore(1));
    assertEquals(match.getRoundScore(1) + 8 + 1, match.getTotalScore());
  }

  @Test
  void should_have_total_score_equal_all_4_throws_when_record_throw_given_round1_not_spare_and_round2_not_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(5);
    match.recordThrow(3);

    match.recordThrow(8);
    match.recordThrow(1);

    // Assert
    assertEquals(5 + 3 + 8 + 1, match.getTotalScore());
  }

  @Test
  void should_have_round1_score_equal_20_and_total_score_equal_30_when_record_throw_given_round1_strike_and_round2_strike() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(10);
    match.recordThrow(10);

    // Assert
    assertEquals(20, match.getRoundScore(1));
    assertEquals(30, match.getTotalScore());
  }

  @Test
  void should_have_round1_score_equal_20_plus_new_throw_when_record_throw_given_round1_strike_and_round2_strike_then_throw_again() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(10);
    match.recordThrow(10);
    match.recordThrow(5);

    // Assert
    assertEquals(25, match.getRoundScore(1));
  }

  @Test
  void should_have_second_throw_counted_as_round2_when_record_throw_given_round1_strike_and_then_throw_again() {
    // Arrange
    BowlingMatch match = new BowlingMatch();

    // Act
    match.recordThrow(10);
    match.recordThrow(5);

    // Assert
    assertEquals(5, match.getRoundScore(2));
  }


  @Test
  void should_have_round10_score_equal_20_plus_bonus_throw_when_record_throw_given_round10_first_and_second_throws_are_strike_then_throw_again() {
    // Arrange
    BowlingMatch match = new BowlingMatch();
    for(int i=0; i<9; i++) {
      match.recordThrow(10);
    }

    // Act
    match.recordThrow(10);
    match.recordThrow(10);
    match.recordThrow(5);

    // Assert
    assertEquals(20 + 5, match.getRoundScore(10));
  }

  @Test
  void should_have_round10_score_equal_10_plus_bonus_throw_when_record_throw_given_round10_second_throw_spare_then_throw_again() {
    // Arrange
    BowlingMatch match = new BowlingMatch();
    for(int i=0; i<9; i++) {
      match.recordThrow(10);
    }

    // Act
    match.recordThrow(6);
    match.recordThrow(4);
    match.recordThrow(5);

    // Assert
    assertEquals(10 + 5, match.getRoundScore(10));
  }

  @Test
  void should_have_round10_score_equal_sum_of_both_throws_when_record_throw_given_round10_is_neither_strike_or_spare() {
    // Arrange
    BowlingMatch match = new BowlingMatch();
    for(int i=0; i<9; i++) {
      match.recordThrow(10);
    }

    // Act
    match.recordThrow(7);
    match.recordThrow(1);

    // Assert
    assertEquals(7 + 1, match.getRoundScore(10));
  }

  @Test
  void should_be_perfect_score_300_when_record_throw_given_12_strikes_in_the_row() {
    // Arrange
    BowlingMatch match = new BowlingMatch();
    for(int i=0; i<12; i++) {
      match.recordThrow(10);
    }

    // Assert
    assertEquals(300, match.getTotalScore());
  }
}
