package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
    @Test
    fun testGet() {
        val item1 = Item("A")
        val item2 = Item("B")
        val item3 = Item("C")

        collection.addItem(item1)
        collection.addItem(item2)
        collection.addItem(item3)

        assertEquals(item1, collection.get(0))
        assertEquals(item2, collection.get(1))
        assertEquals(item3, collection.get(2))
    }

    @Test
    fun testRemove() {
        val item1 = Item("A")
        val item2 = Item("B")

        collection.addItem(item1)
        collection.addItem(item2)

        val oldSize = collection.size()
        collection.remove(item1)

        val newSize = collection.size()

        assert(1 == newSize && 2 == oldSize)
        assertEquals(item2, collection.get(0))
    }

}