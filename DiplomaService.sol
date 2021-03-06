pragma solidity >=0.4.22 <0.7.0;

contract DiplomaService {
    
    address constant  ADMIN_ADDRESS = 0x90F8bf6A479f320ead074411a4B0e7944Ea8c9C1;

    HistoryRecord[] private historyRecords;

    function createOrUpdateData(address _owner, string memory _name, string memory _surname, uint8  _mark, string memory _markl , string memory _hash) public {
        checkAdminPermission();
        historyRecords.push(HistoryRecord({incidentTime : now, owner : _owner, name : _name, surname : _surname , mark : _mark , markl : _markl, hash : _hash}));
    }

    function getHistoryRecord(uint index) public view returns 

    (uint256 incidentTime, address owner, string memory name, string memory surname, uint8  mark, string memory markl, string memory hash) {
        checkAdminPermission();
        return (historyRecords[index].incidentTime, historyRecords[index].owner,
                historyRecords[index].name, historyRecords[index].surname, historyRecords[index].mark, historyRecords[index].markl, historyRecords[index].hash);
    }

    struct HistoryRecord {
        uint256 incidentTime;
        address owner;
        string name;
        string surname;
        uint8 mark;
        string markl;
        string hash;
    }

    // utility functions
    function getHistoryRecordLength() public view returns (uint) {
        checkAdminPermission();
        return historyRecords.length;

    }

    function checkAdminPermission() private view {
        if (msg.sender != ADMIN_ADDRESS) {
            revert();
     }
    }

}