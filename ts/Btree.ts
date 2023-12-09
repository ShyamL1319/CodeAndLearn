class BtreeNode{ 
    data;
    leftNode?: BtreeNode;
    rightNode?: BtreeNode;
    constructor(data) { 
        this.data = data;
    }
}

class BST{ 
    root?: BtreeNode;
    comparator: (a, b) => number;

    insert(data): BtreeNode | undefined {
        if (!this.root) {
            this.root = new BtreeNode(data);
            return this.root;
        }
        if (data <= this.root.data) {
            this.root.leftNode = this.insert(this.root.leftNode);
        } else { 
            this.root.rightNode = this.insert(this.root.rightNode);
        }
    }
}


