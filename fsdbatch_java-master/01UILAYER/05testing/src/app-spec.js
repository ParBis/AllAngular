describe("A suite", function() {

    

    it("contains spec with an expectation", function() {
      expect(true).toBe(true);
    });


    it("4 + 5 should always be 9", ()=>{
        let result = sum(4,5)
        expect(result).toBe(9)
    })

    it("-4 + -5 should always be 9", ()=>{
        let result = sum(-4,-5)
        expect(result).toBe(-9)
    })


  });