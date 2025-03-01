@testable import KMPSampleSwiftPackage
import Testing

struct PriorityQueueTests {
    final class PQItem: Equatable {
        static func == (lhs: PQItem, rhs: PQItem) -> Bool {
            lhs.value == rhs.value
        }

        let value: Int

        init(value: Int) {
            self.value = value
        }
    }

    private func createPriorityQueueUsingMinHeap() -> PriorityQueue<PQItem> {
        return PriorityQueue<PQItem> { a, b in
            Int32(a.value - b.value) // Min-heap (smallest element first)
        }
    }

    @Test
    func testInitialization() {
        let pq = createPriorityQueueUsingMinHeap()
        #expect(pq.isEmpty() == true)
    }

    @Test
    func testPushAndSize() {
        let pq = createPriorityQueueUsingMinHeap()
        pq.push(PQItem(value: 5))
        #expect(pq.isEmpty() == false)
        #expect(pq.size() == 1)
    }

    @Test
    func testPeek() {
        let pq = createPriorityQueueUsingMinHeap()
        pq.push(PQItem(value: 3))
        #expect(pq.peek()?.value == 3)
    }

    @Test
    func testPop() {
        let pq = createPriorityQueueUsingMinHeap()
        pq.push(PQItem(value: 10))
        pq.push(PQItem(value: 2))
        pq.push(PQItem(value: 5))
        pq.push(PQItem(value: 1))
        pq.push(PQItem(value: 8))

        #expect(pq.pop()?.value == 1)
        #expect(pq.pop()?.value == 2)
        #expect(pq.pop()?.value == 5)
        #expect(pq.pop()?.value == 8)
        #expect(pq.pop()?.value == 10)
        #expect(pq.isEmpty())
    }

    @Test
    func testPopWithMaxHeap() async throws {
        let pq = PriorityQueue<PQItem> { a, b in
            Int32(b.value - a.value) // Max-heap
        }
        pq.push(PQItem(value: 10))
        pq.push(PQItem(value: 2))
        pq.push(PQItem(value: 5))
        pq.push(PQItem(value: 1))
        pq.push(PQItem(value: 8))

        #expect(pq.pop()?.value == 10)
        #expect(pq.pop()?.value == 8)
        #expect(pq.pop()?.value == 5)
        #expect(pq.pop()?.value == 2)
        #expect(pq.pop()?.value == 1)
        #expect(pq.isEmpty())
    }

    @Test
    func testSizeAfterPop() {
        let pq = createPriorityQueueUsingMinHeap()
        pq.push(PQItem(value: 7))
        #expect(pq.size() == 1)
        #expect(pq.pop() == PQItem(value: 7))
        #expect(pq.size() == 0)
    }
}
