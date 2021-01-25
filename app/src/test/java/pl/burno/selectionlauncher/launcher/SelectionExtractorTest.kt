package pl.burno.selectionlauncher.launcher

import org.junit.Assert.assertEquals
import org.junit.Test

class SelectionExtractorTest {

    @Test
    fun `extract exact username`() {
        assertExtracting("librunos", "librunos")
    }

    @Test
    fun `extract username with prefix`() {
        assertExtracting("ig: librunos", "librunos")
    }

    @Test
    fun `extract last username`() {
        assertExtracting("john paul 2 librunos", "librunos")
    }

    @Test
    fun `extract username from unsupported characters`() {
        assertExtracting("/ librunos [][/']", "librunos")
    }

    @Test
    fun `extract special username`() {
        assertExtracting("l_i.b", "l_i.b")
    }

    @Test
    fun `do not extract unsupported characters`() {
        assertExtracting("[][][]", null)
    }

    private fun assertExtracting(selection: String, expected: String?) {
        assertEquals(expected, SelectionExtractor.extract(selection))
    }
}