package com.github.zsoltk.composeribs.client.interactorusage

import androidx.lifecycle.Lifecycle
import com.github.zsoltk.composeribs.core.clienthelper.interactor.Interactor

class InteractorExample : Interactor<InteractorNode>() {

    override fun onLifecycleUpdated(state: Lifecycle.State) {
        if (state == Lifecycle.State.CREATED) {
            whenChildAttached(Child2Node::class) { _: Lifecycle, _: Child2Node ->
                node.child2InfoState = "Child2 has been attached"
            }

            whenChildrenAttached(
                Child2Node::class,
                Child3Node::class
            ) { _: Lifecycle, _: Child2Node, _: Child3Node ->
                node.child2And3InfoState = "Child2 and Child3 have been attached"
            }
        }
    }
}
