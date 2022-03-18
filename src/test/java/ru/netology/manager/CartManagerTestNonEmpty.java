package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.PurchaseItem;
import ru.netology.repository.CartRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class CartManagerTestNonEmpty {
    private CartRepository repository = Mockito.mock(CartRepository.class);

    private CartManager manager = new CartManager(repository);
    private PurchaseItem first = new PurchaseItem(1, 1, "first", 100, 2);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 10, 1);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 1, 2);

    @Test
    public void shouldCalculateSum() {
        PurchaseItem[] returned = {first, second, third};
        doReturn(returned).when(repository).findAll(); // возвра

        int expected = 212;
        int actual = manager.sum();

        assertEquals(expected, actual);

        verify(repository).findAll();
    }

}