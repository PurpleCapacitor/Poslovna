package ftn.poslovna.inf.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.poslovna.inf.converters.PriceTableConverter;
import ftn.poslovna.inf.domain.PriceTable;
import ftn.poslovna.inf.domain.PriceTableItem;
import ftn.poslovna.inf.dto.CopyDTO;
import ftn.poslovna.inf.dto.PriceTableDTO;
import ftn.poslovna.inf.repository.PriceTableItemRepository;
import ftn.poslovna.inf.repository.PriceTableRepository;

@Service
public class PriceTableService {
	
	@Autowired
	PriceTableRepository priceTableRepository;
	
	@Autowired
	PriceTableConverter priceTableConverter;
	
	@Autowired
	PriceTableItemRepository priceTableItemRepository;
	
	public List<PriceTable> findAll() {
		return priceTableRepository.findAll();
	}
	
	public PriceTable findOne(Long id) {
		Optional<PriceTable> o = priceTableRepository.findById(id);
		return o.get();
	}
	
	public PriceTable save(PriceTableDTO dto) {
		PriceTable ord = priceTableConverter.DtoToEntity(dto);
		return priceTableRepository.save(ord);
	}

	public PriceTable delete(Long id) {
		PriceTable i = this.findOne(id);
		if(i == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant");
		}
		priceTableRepository.delete(i);
		return i;
	}

	public PriceTable copy(PriceTable priceTable,CopyDTO copyDTO) {
		PriceTable copyPT = new PriceTable();
		copyPT.setCompany(priceTable.getCompany());
		Date today = new Date();
		copyPT.setImplicationDate(today);
		copyPT.setPriceTableNum(priceTable.getPriceTableNum());
		copyPT = priceTableRepository.save(copyPT);
		for(PriceTableItem item : priceTable.getPriceTableItems()){
			PriceTableItem newItem = new PriceTableItem();			
			newItem.setCatalog(item.getCatalog());
			item.setCatalog(null);
			newItem.setItemName(item.getItemName());
			float newPrice=item.getItemPrice();
			if(copyDTO.isIncrease()){
				newPrice=newPrice+(newPrice*copyDTO.getProcenat())/100;
			}
			else{
				newPrice=newPrice-(newPrice*copyDTO.getProcenat())/100;
			}
			newItem.setItemPrice(newPrice);
			newItem.setPriceTable(copyPT);
			priceTableItemRepository.save(newItem);
			priceTableItemRepository.save(item);
		}
		return copyPT;
	}

}
