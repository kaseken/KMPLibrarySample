import Foundation
import SwiftUI

struct ContentView: View {
    private func createRandomIntArray(
        size: Int,
        range: ClosedRange<Int> = -100 ... 100
    ) -> [Int] {
        return (0 ..< size).map { _ in Int.random(in: range) }
    }

    private var message: String {
        let array = createRandomIntArray(size: 5)
        let min = PriorityQueueUtil.pickMinimum(from: array)!
        return "The minimum element in \(String(describing: array)) is \(String(describing: min))."
    }

    var body: some View {
        VStack {
            Text(message)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
